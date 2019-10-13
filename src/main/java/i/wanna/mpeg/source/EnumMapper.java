package i.wanna.mpeg.source;

import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@NoArgsConstructor
public class EnumMapper {

    private Map<String, List<CodeGroupService>> factory = new LinkedHashMap<>();

    public void put(String key, Class<? extends CodeInter> e){
        factory.put(key, toEnumValues(e));
    }

    private List<CodeGroupService> toEnumValues(Class<? extends CodeInter> e){
        return Arrays.stream(e.getEnumConstants()).map(CodeGroupService::new).collect(Collectors.toList());
    }

    public List<CodeGroupService> get(String key){
        return factory.get(key);
    }

    public Map<String, List<CodeGroupService>> get(List<String> keys){
        if(keys == null || keys.size() == 0){
            return new LinkedHashMap<>();
        }
        return keys.stream()
                .collect(Collectors.toMap(Function.identity(), key -> factory.get((key))));
    }

    public Map<String, List<CodeGroupService>> getAll() {return factory;}

}
