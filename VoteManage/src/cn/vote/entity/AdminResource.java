package cn.vote.entity;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class AdminResource implements Serializable {
	private Integer id;
    private Resource resource;
    private Admin adminByAdminId;
    private Admin adminByAllocationId; // 创建人
    private Date allocationTime;

    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Resource getResource() {
        return this.resource;
    }
    public void setResource(Resource resource) {
        this.resource = resource;
    }
    public Admin getAdminByAdminId() {
        return this.adminByAdminId;
    }
    public void setAdminByAdminId(Admin adminByAdminId) {
        this.adminByAdminId = adminByAdminId;
    }
    public Admin getAdminByAllocationId() {
        return this.adminByAllocationId;
    }
    public void setAdminByAllocationId(Admin adminByAllocationId) {
        this.adminByAllocationId = adminByAllocationId;
    }
    public Date getAllocationTime() {
        return this.allocationTime;
    }
    public void setAllocationTime(Date allocationTime) {
        this.allocationTime = allocationTime;
    }
}