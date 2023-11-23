package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GlobalCorsConfig implements WebMvcConfigurer {

                  @Override
                  public void addCorsMappings(CorsRegistry registry) {
                                    String frontendDomain = System.getenv("FRONTEND_DOMAIN");
                                    System.out.println("Checking result! : " + frontendDomain);
                                    registry.addMapping("/**") // すべてのパスに適用
                                                                        .allowedOrigins(frontendDomain) // フロントエンドサーバーのオリジンを許可
                                                                        .allowedMethods("GET", "POST", "PUT", "DELETE",
                                                                                                            "OPTIONS") // 許可するHTTPメソッド
                                                                        .allowedHeaders("*") // すべてのヘッダーを許可
                                                                        .allowCredentials(true) // クッキーを許可
                                                                        .maxAge(3600); // プリフライトレスポンスのキャッシュ時間（秒）
                  }
}
