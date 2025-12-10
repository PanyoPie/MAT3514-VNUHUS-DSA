package vn.io.tunaa.dsa.revision_2526_1st_midterm_2_1.ex2__dictionary;

@SuppressWarnings("unchecked")
public class Dictionary {
    private DictList<String> enList = null; // Danh sách lưu các từ tiếng Anh
    private DictList<String> viList = null; // Danh sách lưu các từ tiếng Việt


    //	Phương thức loadDictionary(String[] en, String[] vi), phương thức này thực hiện nạp từ điển,
    //lưu các phần tử trong mảng en vào danh sách chứa các từ tiếng Anh,
    //và các phần từ trong mảng vi vào danh sách chứa các từ tiếng Việt.
    public void loadDictionary(String[] en, String[] vi) {
        enList = new DictList<>();
        viList = new DictList<>();

        for (String word : en) {
            enList.add(word);
        }

        for (String word : vi) {
            viList.add(word);
        }
    }

    //	Phương thức translate(DictList en),
    //phương thức này trả lại 1 danh sách các từ tiếng Việt tương ứng với các từ trong danh sách en.

    public DictList<String> translate(DictList<String> en) {
        DictList<String> result = new DictList<>();

        for (int i = 0; i < en.size(); i++) {
            String enWord = en.get(i);

            for (int j = 0; j < enList.size(); j++) {
                if (enList.get(j).equals(enWord)) {
                    result.add(viList.get(j));
                    break;
                }
            }
        }

        return result;
    }
}