import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ApiResponses(value = {
    @ApiResponse(code = 200, message = HttpStatuses.OK),
    @ApiResponse(code = 201, message = HttpStatuses.CREATED),
    @ApiResponse(code = 400, message = HttpStatuses.BAD_REQUEST),
    @ApiResponse(code = 404, message = HttpStatuses.NOT_FOUND)
})
@RestController
@RequestMapping(RANK)
public class RankController {

    @Autowired
    private RankService rankService;

    @GetMapping("/all")
    public List<RankDTO> getAllRanks() {
        return rankService.getAllRanks();
    }

    @GetMapping("/{id}")
    public RankDTO getRankById(@PathVariable Long id) {
        return rankService.getRankById(id);
    }

    @GetMapping("/name/{name}")
    public RankDTO getByName(@PathVariable String name) {
        return rankService.getByName(name);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody RankPostDTO rank, @PathVariable Long id) {
        rankService.update(id, rank);
    }

    @PostMapping
    public void save(@RequestBody RankPostDTO rank) {
        rankService.save(rank);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        rankService.remove(id);
    }

}
