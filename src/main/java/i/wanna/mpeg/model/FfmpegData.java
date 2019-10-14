package i.wanna.mpeg.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class FfmpegData {
    private final Double mediaPresentationDuration;
    private final Integer minBufferTime;
    private final String ori_file_path;
    private final String output_path;

}
