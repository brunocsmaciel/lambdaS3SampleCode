package br.com.parcaseparceiros.lambdaeventobuckets;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Handler implements RequestHandler<String, String> {

    private final String nomeBucket = "nomeDoBucket";


    @Override
    public String handleRequest(String textoEntrada, Context context) {

        AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).build();

        try {
            var conteudo = textoEntrada;

            InputStream inputStream = new ByteArrayInputStream(conteudo.getBytes(StandardCharsets.UTF_8));

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(conteudo.length());

            s3Client.putObject(new PutObjectRequest(nomeBucket, "example.txt", inputStream, metadata));

            return "Put executado com sucesso!";

        } catch (Exception e) {
            return "Erro ao postar no bucket" + e.getMessage();
        }

    }




}