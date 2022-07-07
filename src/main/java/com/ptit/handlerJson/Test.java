package com.ptit.handlerJson;

import com.ptit.model.Movie;
import org.json.simple.parser.ParseException;

import static com.ptit.handlerJson.ParseJson.handlerJson;

public class Test {
    public static void main(String[] args) throws ParseException {
        String json = "{\"status\":true,\"msg\":\"\",\"movie\":{\"modified\":{\"time\":\"2022-05-05T08:15:10.000Z\"},\"_id\":\"627365fc3a2c0c6289bc778e\",\"name\":\"Kimmy bất bại (Phần 1)\",\"origin_name\":\"Unbreakable Kimmy Schmidt (Season 1)\",\"content\":\"<p>Khi một phụ nữ được giải cứu khỏi một giáo phái tận thế và đến Thành phố New York, cô phải xoay xở với thế giới mà cô từng nghĩ không còn tồn tại nữa.</p>\",\"type\":\"series\",\"status\":\"completed\",\"thumb_url\":\"https://img.ophim.tv/uploads/movies/kimmy-bat-bai-phan-1-thumb.jpg\",\"is_copyright\":\"off\",\"sub_docquyen\":\"off\",\"trailer_url\":\"\",\"time\":\"24phút/tập\",\"episode_current\":\"Hoàn Tất (13/13)\",\"episode_total\":\"13 Tập\",\"quality\":\"HD\",\"lang\":\"Vietsub\",\"notify\":\"\",\"showtimes\":\"\",\"slug\":\"kimmy-bat-bai-phan-1\",\"year\":2015,\"actor\":[\"Ellie Kemper\",\" Jane Krakowski\",\" Tituss Burgess\",\" Carol Kane\"],\"director\":[\"\"],\"category\":[{\"name\":\"Hài Hước\"}],\"country\":[{\"name\":\"Âu Mỹ\"}]},\"episodes\":[{\"server_name\":\"Vietsub #1\",\"server_data\":[{\"name\":\"1\",\"slug\":\"1\",\"filename\":\"Kimmy bất bại_S01E01_Kimmy ra ngoài!\",\"link_embed\":\"https://hd.hdbophim.com/share/73c83a253e66cb5877f2d7f8beeba07f\",\"link_m3u8\":\"https://hd.hdbophim.com/20220505/10688_54969f57/index.m3u8\"},{\"name\":\"2\",\"slug\":\"2\",\"filename\":\"Kimmy bất bại_S01E02_Kimmy có việc!\",\"link_embed\":\"https://hd.hdbophim.com/share/b8043b9b976639acb17b035ab8963f18\",\"link_m3u8\":\"https://hd.hdbophim.com/20220505/10689_eba4c1f9/index.m3u8\"},{\"name\":\"3\",\"slug\":\"3\",\"filename\":\"Kimmy bất bại_S01E03_Kimmy hẹn hò!\",\"link_embed\":\"https://hd.hdbophim.com/share/79e0effe60c1d4c057037f430cd25b73\",\"link_m3u8\":\"https://hd.hdbophim.com/20220505/10690_d3be5668/index.m3u8\"},{\"name\":\"4\",\"slug\":\"4\",\"filename\":\"Kimmy bất bại_S01E04_Kimmy đi bác sĩ!\",\"link_embed\":\"https://hd.hdbophim.com/share/77b88288ebae7b17b7c8610a48c40dd1\",\"link_m3u8\":\"https://hd.hdbophim.com/20220505/10691_ca042d3e/index.m3u8\"},{\"name\":\"5\",\"slug\":\"5\",\"filename\":\"Kimmy bất bại_S01E05_Kimmy hôn trai!\",\"link_embed\":\"https://hd.hdbophim.com/share/8640ff6ca914c9855203ac93e4c05119\",\"link_m3u8\":\"https://hd.hdbophim.com/20220505/10692_17de8522/index.m3u8\"},{\"name\":\"6\",\"slug\":\"6\",\"filename\":\"Kimmy bất bại_S01E06_Kimmy đi học!\",\"link_embed\":\"https://hd.hdbophim.com/share/a8fbbd3b11424ce032ba813493d95ad7\",\"link_m3u8\":\"https://hd.hdbophim.com/20220505/10693_e1111617/index.m3u8\"},{\"name\":\"7\",\"slug\":\"7\",\"filename\":\"Kimmy bất bại_S01E07_Kimmy dự tiệc!\",\"link_embed\":\"https://hd.hdbophim.com/share/c1234a24b3825382a0e1ac3e1d925b13\",\"link_m3u8\":\"https://hd.hdbophim.com/20220505/10694_ee723959/index.m3u8\"},{\"name\":\"8\",\"slug\":\"8\",\"filename\":\"Kimmy bất bại_S01E08_Kimmy tệ toán!\",\"link_embed\":\"https://hd.hdbophim.com/share/445dc1bd2498d250b1a65a9bbe4bb5d9\",\"link_m3u8\":\"https://hd.hdbophim.com/20220505/10695_b2005321/index.m3u8\"},{\"name\":\"9\",\"slug\":\"9\",\"filename\":\"Kimmy bất bại_S01E09_Sinh nhật Kimmy!\",\"link_embed\":\"https://hd.hdbophim.com/share/43bb733c1b62a5e374c63cb22fa457b4\",\"link_m3u8\":\"https://hd.hdbophim.com/20220505/10696_d6f21cc9/index.m3u8\"},{\"name\":\"10\",\"slug\":\"10\",\"filename\":\"Kimmy bất bại_S01E10_Kimmy với tình tay ba!\",\"link_embed\":\"https://hd.hdbophim.com/share/2719d3088a5fe4ee5163a6486db4e179\",\"link_m3u8\":\"https://hd.hdbophim.com/20220505/10697_04ec66ca/index.m3u8\"},{\"name\":\"11\",\"slug\":\"11\",\"filename\":\"Kimmy bất bại_S01E11_Kimmy đạp xe!\",\"link_embed\":\"https://hd.hdbophim.com/share/c0e0b7080b94f208328b48cbea738d86\",\"link_m3u8\":\"https://hd.hdbophim.com/20220505/10698_f55825c4/index.m3u8\"},{\"name\":\"12\",\"slug\":\"12\",\"filename\":\"Kimmy bất bại_S01E12_Kimmy ra tòa!\",\"link_embed\":\"https://hd.hdbophim.com/share/0868dbe2d591f3c1beb2f6dd50bdb72e\",\"link_m3u8\":\"https://hd.hdbophim.com/20220505/10699_592d017d/index.m3u8\"},{\"name\":\"13\",\"slug\":\"13\",\"filename\":\"Kimmy bất bại_S01E13_Kimmy làm bánh!\",\"link_embed\":\"https://hd.hdbophim.com/share/c3581d2150ff68f3b33b22634b8adaea\",\"link_m3u8\":\"https://hd.hdbophim.com/20220505/10700_125707bc/index.m3u8\"}]}]}";
        Movie movie = handlerJson(json);


    }
}