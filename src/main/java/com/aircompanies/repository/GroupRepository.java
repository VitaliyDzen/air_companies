import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    List<Group> findByInstituteName(String name);

    Group findByName(String name);

    @Query("from Group a where a.name like concat('%', :name, '%')")
    List<Group> findAllByName(@Param("name") String name);
}
