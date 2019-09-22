package i.wanna.mpeg.source;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CodeGroupService {
    private String title;
    private String value;

    public CodeGroupService(CodeInter codeInter){
        title = codeInter.getTitle();
        value = codeInter.getValue();
    }

}