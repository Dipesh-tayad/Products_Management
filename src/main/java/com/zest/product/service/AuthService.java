//package com.zest.product.service;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.zest.product.config.JwtService;
//import com.zest.product.dto.AuthResponse;
//import com.zest.product.dto.LoginRequest;
//import com.zest.product.entity.User;
//import com.zest.product.repository.UserRepository;
//
//@Service
//public class AuthService {
//
//    private final UserRepository userRepository;
//    private final JwtService jwtService;
//    private final BCryptPasswordEncoder encoder;
//
//    public AuthService(UserRepository userRepository,
//                       JwtService jwtService,
//                       BCryptPasswordEncoder encoder) {
//        this.userRepository = userRepository;
//        this.jwtService = jwtService;
//        this.encoder = encoder;
//    }
//
//    public AuthResponse login(LoginRequest request) {
//
//        User user = userRepository.findByUsername(request.getUsername())
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        if (!encoder.matches(request.getPassword(), user.getPassword())) {
//            throw new RuntimeException("Invalid credentials");
//        }
//
//        String token = jwtService.generateToken(user.getUsername());
//
//        return new AuthResponse(token);   // ✅ FIXED
//    }
//}