package br.com.aws_kafka_consumer.services.ses;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ses.SesClient;

public class Configurations {
    static SesClient getSesClient() {

        Region region = Region.US_EAST_1;
        SesClient sesClient = SesClient.builder()
                .credentialsProvider(Authentication.getCredentials())
                .region(region)
                .build();

        return sesClient;
    }
}
