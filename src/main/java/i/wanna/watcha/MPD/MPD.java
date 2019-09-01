package i.wanna.watcha.MPD;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class MPD implements MpdInter{

    private ArrayList<Period> apdList = new ArrayList<>();

    @Override
    public void MpdXmlGenerater(){
        System.out.println("MpdXmlGenerater == xml 파일 규격 만드는 함수입니다.");
    }

}
