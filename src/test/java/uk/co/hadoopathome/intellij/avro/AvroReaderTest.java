package uk.co.hadoopathome.intellij.avro;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AvroReaderTest {
    @Test
    public void testGetSchema() throws IOException {
        File file = new File(getClass().getClassLoader().getResource("twitter.avro").getFile());
        AvroReader avroReader = new AvroReader(file);
        String schema = avroReader.getSchema();
        assertTrue(schema.contains("A basic schema for storing Twitter messages"));
    }

    @Test
    public void testGetRecords() throws IOException {
        File file = new File(getClass().getClassLoader().getResource("twitter.avro").getFile());
        AvroReader avroReader = new AvroReader(file);
        List<String> records = avroReader.getRecords(100);
        assertEquals(2, records.size());
        String firstRecord = records.get(0);
        assertTrue(firstRecord.contains("Nerf paper"));
    }
}