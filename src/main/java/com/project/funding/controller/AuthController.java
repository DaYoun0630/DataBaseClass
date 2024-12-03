package com.project.funding.controller;

import com.project.funding.payload.ApiResponse;
import com.project.funding.payload.LoginRequest;
import com.project.funding.payload.SignUpRequest;
import com.project.funding.model.User;
import com.project.funding.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UserRepository userRepository;

    /**
     * 회원가입 처리 메서드
     * @param signUpRequest 회원가입 요청 데이터
     * @return ResponseEntity 회원가입 성공 또는 실패 응답
     */
//    @PostMapping("/signup")
//    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
//        // ID 중복 체크
//        if (userRepository.existsById(signUpRequest.getUserId())) {
//            return ResponseEntity.badRequest().body(new ApiResponse(false, "사용 중인 아이디입니다."));
//        }
//
//        // 사용자 생성 및 필드 설정
//        User user = new User();
//        user.setUserId(signUpRequest.getUserId());
//        user.setUserName(signUpRequest.getUserName());
//        user.setUserPassword(signUpRequest.getUserPassword()); // 비밀번호는 해시 처리 등 추가 고려 필요
//        user.setUserPhoneNumber(signUpRequest.getUserPhoneNumber());
//        user.setUserBirthdate(LocalDate.parse(signUpRequest.getUserBirthdate()));
//        user.setUserAddress(signUpRequest.getUserAddress());
//
//        // 사용자 저장
//        try {
//            userRepository.save(user);
//        } catch (ConstraintViolationException e) {
//            e.getConstraintViolations().forEach(violation -> {
//                logger.error("유효성 검사 실패 - {}: {}", violation.getPropertyPath(), violation.getMessage());
//            });
//            throw e; // 예외를 다시 던져 호출자에게 알림
//        } catch (Exception e) {
//            logger.error("회원가입 처리 중 오류 발생: {}", e.getMessage());
//            throw e;
//        }
//
//        // 성공 응답 반환
//        return ResponseEntity.ok(new ApiResponse(true, "회원가입이 완료되었습니다."));
//    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        // ID 중복 체크
        if (userRepository.existsById(signUpRequest.getUserId())) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "사용 중인 아이디입니다."));
        }

        // 이메일 중복 체크
        if (userRepository.existsByUserEmail(signUpRequest.getUserEmail())) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "사용 중인 이메일입니다."));
        }

        // 사용자 생성
        User user = new User();
        user.setUserId(signUpRequest.getUserId());
        user.setUserName(signUpRequest.getUserName());
        user.setUserEmail(signUpRequest.getUserEmail());
        user.setUserPassword(signUpRequest.getUserPassword());
        user.setUserPhoneNumber(signUpRequest.getUserPhoneNumber());
        user.setUserBirthdate(LocalDate.parse(signUpRequest.getUserBirthdate()));
        user.setUserAddress(signUpRequest.getUserAddress());

        // 사용자 저장
        userRepository.save(user);

        return ResponseEntity.ok(new ApiResponse(true, "회원가입이 완료되었습니다."));
    }

    /**
     * 로그인 처리 메서드
     * @param loginRequest 로그인 요청 데이터
     * @return ResponseEntity 로그인 성공 또는 실패 응답
     */
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody @Valid LoginRequest loginRequest) {
        logger.debug("로그인 요청 - 아이디: {}", loginRequest.getUserId());

        // 사용자 정보 확인 (아이디로 검색)
        Optional<User> userOptional = userRepository.findByUserId(loginRequest.getUserId());

        if (!userOptional.isPresent()) {
            logger.warn("등록된 회원이 아닙니다. 아이디가 존재하지 않습니다.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ApiResponse(false, "등록된 회원이 아닙니다. 아이디와 비밀번호를 확인해주세요."));
        }

        User user = userOptional.get();

        // 입력된 비밀번호와 DB에 저장된 비밀번호 비교
        if (!loginRequest.getUserPassword().equals(user.getUserPassword())) {
            logger.warn("비밀번호 불일치 - 아이디: {}, 입력된 비밀번호: {}, DB의 비밀번호: {}",
                    loginRequest.getUserId(), loginRequest.getUserPassword(), user.getUserPassword());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ApiResponse(false, "비밀번호가 일치하지 않습니다."));
        }

        logger.info("로그인 성공 - 아이디: {}", loginRequest.getUserId());
        return ResponseEntity.ok(new ApiResponse(true, "로그인 성공"));
    }
}