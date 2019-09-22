package i.wanna.mpeg.source;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CodeConfig {

    @Bean
    public EnumMapper enumMapper(){
        EnumMapper enumMapper = new EnumMapper();

        enumMapper.put("RelationCode", RelationCode.class);
        enumMapper.put("TimeCode", TimeCode.class);
        enumMapper.put("JodiacCode", JodiacCode.class);
        enumMapper.put("BlackCode", BlackCode.class);
        enumMapper.put("PurchaseRootCode", PurchaseRootCode.class);

        return enumMapper;
    }

}