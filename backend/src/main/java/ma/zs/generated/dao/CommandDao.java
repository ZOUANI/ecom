package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.Command;


@Repository
public interface CommandDao extends JpaRepository<Command,Long> {

	Command findByReference(String reference);
       int deleteByReference(String reference);

       List<Command> findByDeliveryCode(String code);
       int deleteByDeliveryCode(String code);       
       List<Command> findByDeliveryId(Long id);
       int deleteByDeliveryId(Long id);
       List<Command> findByValidatorCode(String code);
       int deleteByValidatorCode(String code);       
       List<Command> findByValidatorId(Long id);
       int deleteByValidatorId(Long id);
       List<Command> findByAdminCode(String code);
       int deleteByAdminCode(String code);       
       List<Command> findByAdminId(Long id);
       int deleteByAdminId(Long id);
       List<Command> findByClientId(Long id);
       int deleteByClientId(Long id);
       List<Command> findByOrderStatusLabel(String label);
       int deleteByOrderStatusLabel(String label);       
       List<Command> findByOrderStatusId(Long id);
       int deleteByOrderStatusId(Long id);
       List<Command> findByCityName(String name);
       int deleteByCityName(String name);       
       List<Command> findByCityId(Long id);
       int deleteByCityId(Long id);

}