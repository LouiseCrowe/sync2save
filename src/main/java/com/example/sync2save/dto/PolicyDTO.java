package com.example.sync2save.dto;

import com.example.sync2save.model.Policy;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PolicyDTO {
    private Long policyId;
    private String type;
    private String description;
    private Long customerId;

    public PolicyDTO() {

    }

    public PolicyDTO(Policy policy) {
        this.policyId = policy.getPolicyId();
        this.customerId = policy.getCustomerId();
        this.type = policy.getType();
        this.description = policy.getDescription();
    }

    public PolicyDTO(long policyId, String type, String description, long customerId) {
        this.policyId = policyId;
        this.type = type;
        this.description = description;
        this.customerId = customerId;
    }

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
