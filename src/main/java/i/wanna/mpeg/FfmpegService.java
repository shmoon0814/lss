package i.wanna.mpeg;

import com.coremedia.iso.IsoFile;
import com.googlecode.mp4parser.FileDataSourceImpl;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FfmpegService {

    //private String inputPath = "C:/video/SampleVideo_1280x720_30mb.mp4";
    private String inputPath = "C:/video/1080p_sample1.mp4";

    private String outputPath = "C:/video/output/";
    private static final Integer cutDuration = 20;
    private final FFmpeg fFmpeg;
    private final FFprobe fFprobe;
    private String frame [] = {"cga", "ega","hd480","hd720","hd1080"};
    //private String resolution [] = {"scale=320:200", "scale=640:350","scale=852:480","scale=1280:720","scale=1920:1080"};
    private String resolution [] = {"scale=320:200", "scale=640:350","scale=852:480"};
    public FfmpegService() throws Exception{
        this.fFmpeg = new FFmpeg("C:\\ffmpeg\\bin\\ffmpeg.exe");
        this.fFprobe = new FFprobe("C:\\ffmpeg\\bin\\ffprobe.exe");
    }

    public double checkFile() throws Exception{
        FileDataSourceImpl fileDataSource = new FileDataSourceImpl(inputPath);
        IsoFile isoFile = new IsoFile(fileDataSource);
        double lengthInSeconds = (double)
                isoFile.getMovieBox().getMovieHeaderBox().getDuration() /
                isoFile.getMovieBox().getMovieHeaderBox().getTimescale();
        return lengthInSeconds;

        //-b =  비디오 비트 레이트(default = 200k, 320k는 되야 볼만함)
        //비트레이트가 화질의 수이다....
    }

    public void wrapper() throws Exception {
        double duration = checkFile();
        if(duration < 100){
            return;
        }else{
            double value = duration / cutDuration;
            Double value2 = Math.floor(value);
            //TODO 인덱스 확인해서 다시돌리세요 쉽세야...
            for(int i =0 ; i < frame.length; i++){
                for(int j=0; j < value2.intValue(); j++) {
                    cutMp4ForEach(j, frame[i], resolution[i]);
                }
                cutMp4ForEach(value2.intValue(), duration, frame[i], resolution[i]);
            }
            System.out.println("File Cut Complete");
        }
    }

    private void cutMp4ForEach(Integer index, String frame , String resolution){

        File file = new File(outputPath + frame + "/");
        if(!file.exists()){
            file.mkdir();
        }

        FFmpegBuilder builder = new FFmpegBuilder()
                .overrideOutputFiles(true)
                .addInput(inputPath)     //입력 영상 경로의
                .addExtraArgs("-ss", String.valueOf(index * cutDuration)) //영상의 i초 위치 부
                .addExtraArgs("-t", String.valueOf(cutDuration)) //20초 동안 재생한 영상
                .addOutput(outputPath + frame + "/pitching_out" + index + ".mp4") //outputpath 위치에
                .addExtraArgs("-vf", resolution) //해상도명 설정
                //.addExtraArgs("-an") //영상의 소리를 제거하고
                .done();    //저장
        FFmpegExecutor excutor = new FFmpegExecutor(fFmpeg, fFprobe);
        excutor.createJob(builder).run();
    }

    private void cutMp4ForEach(Integer index, Double lastDuration, String frame , String resolution){
        File file = new File(outputPath + frame + "/");
        if(!file.exists()){
            file.mkdir();
        }

        FFmpegBuilder builder = new FFmpegBuilder()
                .overrideOutputFiles(true)
                .addInput(inputPath)     //입력 영상 경로의
                .addExtraArgs("-ss", String.valueOf(index * cutDuration)) //영상의 i초 위치 부
                .addExtraArgs("-t", String.valueOf(lastDuration)) //20초 동안 재생한 영상
                .addOutput(outputPath + frame + "/pitching_out" + index + ".mp4") //outputpath 위치에
                //.addExtraArgs("-an") //영상의 소리를 제거하고
                .addExtraArgs("-vf", resolution) //해상도명 설정
                .done();    //저장

        FFmpegExecutor excutor = new FFmpegExecutor(fFmpeg, fFprobe);
        excutor.createJob(builder).run();
    }

}
