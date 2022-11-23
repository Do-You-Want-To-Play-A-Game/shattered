package com.dywtpag.shattered.aws;



import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class S3 {

    public static BufferedImage getImage(String bucket, String key) throws IOException {
        final S3Client s3 = S3Client.builder().region(Region.US_WEST_2).build();
        final GetObjectRequest req = GetObjectRequest
                .builder()
                .bucket(bucket)
                .key(key)
                .build();
        return ImageIO.read(s3.getObjectAsBytes(req).asInputStream());
    }
}
