Skip to content
 
Search or jump to…

Pull requests
Issues
Marketplace
Explore
 
@shmoon0814 
Learn Git and GitHub without any code!
Using the Hello World guide, you’ll start a branch, write comments, and open a pull request.

 
1
0 0 shmoon0814/shmoonlss
 Code  Issues 0  Pull requests 0  Projects 0  Wiki  Security  Insights  Settings
shmoonlss/README.md
@shmoon0814 shmoon0814 Update README.md
887311d 13 minutes ago
51 lines (38 sloc)  1.86 KB
    
2019년 8월 31일 맥북이 없어서 윈도우에 개발환경 셋팅중..

windows10 에서 지원하는 리눅스 깔아서 웹서버 nginx 띄웠다. (리눅스)
openjdk 1.8 버전 깔았다.(윈도우)
이후 mpeg-dash 미디어 스트리밍 서버를 자바로 구현하기 위하여 여러가지 정보를 찾고 있다.

죄다 오픈소스 서버 프로그램만 제공한다. 프로토콜의 이해를 기반으로 쌩으로 짜야할 것 같다. 소스가 있다면 소스 분석후 자바로 컨버팅하는 방식을 취하려 했는대 고난과 역경이 시작될 것 같다.

일단 앞단의 웹서버가 필요한 듯 하다. https://www.nginx.com/blog/scalable-live-video-streaming-nginx-plus-bitmovin/

를 참고하여 nginx 서버의 기본을 찾아보았다. 해당 솔루션은 어떠한 형식으로 구성이 되어있나를 찾아보았다.

뭐 몇가지는 대충 아는거고 현재 사용중에 처음보는 키워드는 application live ffmpeg live on; dash on; dash_path; dash_nested on; 뭐 이런것들이 있었다.

application - 데몬 live ffmpeg - 우리가 아는 영상 컨버팅 툴 live on - 이건 모르겠내 dash on - 이것도 dash_path - 이것도 dash_nested on - 이것도

느낌적인 느낌으로

    application dash {
        live on;

        dash on;
        dash_path /tmp/dash;
        dash_nested on;
    }
dash라는 어플리케이션에 dash로 들어온걸 처리하겠다 정도인거같다. 결국 dash 어플리케이션이 어떻게 구현이 되어있는 지는 알 수가 없기 때문에 다른글을 찾아 봐야 할 것 같다.

호옹이 mpeg-dash 공식 홈페이지가 있나보다.. https://mpeg.chiariglione.org/standards/mpeg-dash 기본 프로토콜이 여기 정의되어있내요 일단 여기까지 하고 스프링 기본 프로젝트를 여기랑 연동시켜야 겠다.

© 2019 GitHub, Inc.
Terms
Privacy
Security
Status
Help
Contact GitHub
Pricing
API
Training
Blog
About
