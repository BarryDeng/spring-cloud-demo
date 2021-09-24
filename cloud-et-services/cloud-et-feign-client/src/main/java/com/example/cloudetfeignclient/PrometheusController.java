package com.example.cloudetfeignclient;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.exporter.common.TextFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

@RestController
public class PrometheusController {
    @Resource
    private CollectorRegistry collectorRegistry;

    @GetMapping(value = "/metrics", produces = "text/plain; version=0.0.4; charset=utf-8")
    public String data() {
        try {
            Writer writer = new StringWriter();
            TextFormat.write004(writer, collectorRegistry.metricFamilySamples());

            return writer.toString();
        } catch (IOException ex) {
            throw new RuntimeException("Writing metrics failed", ex);
        }
    }
}
