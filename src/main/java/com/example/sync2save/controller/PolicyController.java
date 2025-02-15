package com.example.sync2save.controller;

import com.example.sync2save.dto.PolicyDTO;
import com.example.sync2save.model.Policy;
import com.example.sync2save.service.PolicyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/policies")
@CrossOrigin("*")
public class PolicyController {

    private final PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @GetMapping
    public ResponseEntity<List<PolicyDTO>> getAllPolicies() {
        return ResponseEntity.ok(policyService.getAllPolicies());
    }

    @GetMapping("{policyId}")
    public ResponseEntity<PolicyDTO> getPolicyByID(@PathVariable long policyId) {
        return ResponseEntity.ok(this.policyService.getPolicyById(policyId));
    }

    @PostMapping
    public ResponseEntity<PolicyDTO> createPolicy(@RequestBody Policy policy) {
        return ResponseEntity.ok(policyService.createPolicy(policy));
    }


    @PutMapping("/{policyId}")
    public ResponseEntity<?> updatePolicy(@PathVariable long policyId, @RequestBody Policy policy) {
        Optional<PolicyDTO> optionalPolicy = this.policyService.updatePolicy(policyId, policy);
        if(optionalPolicy.isPresent()) {
            return ResponseEntity.ok(optionalPolicy.get());
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{policyId}")
    public ResponseEntity<?> deletePolicyById(@PathVariable long policyId) {
        Optional<PolicyDTO> optionalPolicy = Optional.ofNullable(this.policyService.getPolicyById((policyId)));
        if (optionalPolicy.isPresent()) {
            this.policyService.deletePolicy(policyId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
