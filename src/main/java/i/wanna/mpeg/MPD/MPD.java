package i.wanna.mpeg.MPD;

import i.wanna.mpeg.MPD.SegmentCode.SegmentUrlCode;
import i.wanna.mpeg.source.BlackCode;
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

    public void test(){
    }


}
