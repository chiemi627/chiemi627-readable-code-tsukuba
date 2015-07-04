/**
 * Created by chiemi on 2015/07/04.
 */
public class Recipe {
    public String title;

    public Recipe(){}
    public Recipe(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public static Recipe makeRecipeFromCSV(String line){
        //Recipe�I�u�W�F�N�g�����
        Recipe recipe = new Recipe();
        //CSV�t�@�C������Recipe�f�[�^�����
        String[] items = line.split(",");

        //�Ƃ肠�����ŏ���0�ԖڂɃ^�C�g��
        //TODO: �t�H�[�}�b�g�̕ω��ɑΉ��ł���悤�ɂ���
        recipe.title = items[0];

        return recipe;

    }
}
