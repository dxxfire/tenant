package cn.bobdeng.tenant.domain;

import java.util.List;
import java.util.Optional;

public interface TenantRepository {
    Tenant newTenant(Tenant tenant);

    Optional<Tenant> findById(long id);

    List<Tenant> findTenants(int contactId);

    void deleteTenant(Tenant tenant);

    Optional<RentContact> findLastContact(int apartmentId);

    RentContact saveContact(RentContact rentContact);
}
