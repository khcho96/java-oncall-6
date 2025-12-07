package oncall.dto;

import java.util.List;
import oncall.domain.OnCallPerDay;

public record OnCallResultDto(List<OnCallPerDay> result) {

}
