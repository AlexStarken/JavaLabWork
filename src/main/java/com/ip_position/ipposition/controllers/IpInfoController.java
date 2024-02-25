package com.ip_position.ipposition.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.ip_position.ipposition.entity.IpInfo;
import com.ip_position.ipposition.services.*;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/ip")
public class IpInfoController {

    private final IpInfoService ipInfoService;

    public IpInfoController(IpInfoService ipInfoService) {
        this.ipInfoService = ipInfoService;
    }

    @GetMapping
    public List<IpInfo> getIpInfo(@RequestParam(required = false) String ip) {
        if (ip != null && isValidIpAddress(ip))
            return List.of(ipInfoService.getIpInfo(ip));
        return ipInfoService.getIpsInfo();
    }

    private boolean isValidIpAddress(String ip) {
        return ip.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
    }

    @PostMapping
    public void addNewIpInfo(@RequestBody IpInfo ipInfo) {
        ipInfoService.addNewIpInfo(ipInfo);
    }
}

// curl -X POST -H "Content-Type: application/json" -d '{"city": {"country":
// "United States", "region": "CA", "cityName": "Mountain View"}, "position":
// {"latitude": 37.386, "longitude": -122.0838}, "timeZone":
// "America/Los_Angeles", "provider": {"isp": "Google", "org": "Google LLC",
// "asName": "AS15169"}, "query": "8.8.8.8"}' http://localhost:8080/api/ip