package model.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static model.utils.AvroCommonTypes.*;

@Slf4j
public class AvroErrorMessageSchemaBuilder {

    public static void main(String[] args) throws IOException {
        log.info("Starting building error message schema for Avro");

        Schema errorRecordSchema = SchemaBuilder
            .record("ErrorRecord")
            .namespace("tv.pluto.nile.avro")
            .fields()

            .name("type")
            .doc("The general type of the error, like UNEXPECTED_ERROR, SCHEMA_REGISTRY_ERROR, ...")
            .type(STRING).noDefault()

            .name("message")
            .doc("Detailed error message.")
            .type(OPTIONAL_STRING).withDefault(null)

            .name("rawEventIndex")
            .doc("First index of invalid event if we do not split jsonEvent into bad and good")
            .type(OPTIONAL_INTEGER).withDefault(null)

            .name("customContextIndex")
            .doc("First index of invalid event if we do not split jsonEvent into bad and good")
            .type(OPTIONAL_INTEGER).withDefault(null)
//sdfgdnfjgdfjg
            .endRecord();

        Schema errorMessageSchema = SchemaBuilder
            .record("ErrorMessage")
            .namespace("tv.pluto.nile.avro")
            .fields()

            .name("content")
            .doc("The content of the incoming payload data event.")
            .type(STRING).noDefault()

            .name("errors")
            .doc("A list of errors associated with content.")
            .type(Schema.createArray(errorRecordSchema)).noDefault()

            .endRecord();

        String outputFile = (args.length == 0 || args[0] == null || "".equals(args[0]))
                ? "src/main/resources/schemas/error-message.avsc"
                : args[0];

        String content = errorMessageSchema.toString(true);

        Files.writeString(Path.of(outputFile), content);
        System.out.println(content);
    }

}
