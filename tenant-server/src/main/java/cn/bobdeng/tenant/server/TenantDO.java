package cn.bobdeng.tenant.server;

import cn.bobdeng.tenant.domain.Tenant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_apartment_tenant")
public class TenantDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 20)
    private String comCode;
    @Column(length = 10)
    private String name;
    @Column(length = 15)
    private String mobile;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rent_contract_id", foreignKey = @javax.persistence.ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private RentContractDO rentContract;
    @Column(length = 200)
    private String faceImage;

    public Tenant toEntity() {
        return Tenant.builder()
                .id(getId())
                .comCode(getComCode())
                .mobile(getMobile())
                .name(getName())
                .faceImage(getFaceImage())
                .rentContact(rentContract.toEntity())
                .build();
    }

    public static TenantDO fromEntity(Tenant entity) {
        return TenantDO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .faceImage(entity.getFaceImage())
                .mobile(entity.getMobile())
                .comCode(entity.getComCode())
                .rentContract(RentContractDO.fromEntity(entity.getRentContact()))
                .build();
    }
}
