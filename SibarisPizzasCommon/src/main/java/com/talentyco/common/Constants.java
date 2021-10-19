package com.talentyco.common;

/**
 * Java Title
 *
 * @author Emmanuel Nieto Muñoz
 * @version: xx/10/2021/1.0
 * @see <a href = "" />  </a>
 */

public class Constants {
    public static final String S3_BASE_URI;

    static {
        String bucketName = System.getenv("AWS_BUCKET_NAME");
        String region = System.getenv("AWS_REGION");
        String pattern = "https://%s.s3.%s.amazonaws.com";

        S3_BASE_URI = bucketName == null ? "" : String.format(pattern, bucketName, region);
    }
}