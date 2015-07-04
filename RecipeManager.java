import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RecipeManager {

    ArrayList<Recipe> recipeList;
    String recipefile = "recipe-data.csv";

    public RecipeManager(){
        this.recipeList = new ArrayList<Recipe>();
    }

    //���V�s���ЂƂǉ�����
    public void addRecipe(Recipe recipe){
        this.recipeList.add(recipe);
    }
    //���V�s�����o�͂���
    public int countRecipes(){
        return this.recipeList.size();
    }
    //i�Ԗڂ̃��V�s���o�͂���
    public Recipe getRecipe(int i){
        return this.recipeList.get(i);
    }

    //���V�s���X�g���t�@�C������ǂݍ���
    public void loadRecipesFromFile(){
        try {
            File file = new File(this.recipefile);
            FileReader filereader = new FileReader(file);
            BufferedReader br = new BufferedReader(filereader);
            String line;
            while ((line = br.readLine()) != null) {
                //�s���Ƃ̏�����Recipe�N���X�ōs���Ă��܂�
                Recipe recipe = Recipe.makeRecipeFromCSV(line);
                this.addRecipe(recipe);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("Recipe file can not be found.: "+recipefile);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //main�����F�@�������Ƀ��V�s�t�@�C����
    public static void main(String[] args) {
        //���V�s�}�l�[�W���[��p��
        RecipeManager manager = new RecipeManager();
        //���V�s�t�@�C������f�[�^�����[�h
        manager.loadRecipesFromFile();
        //���V�s�����o�͂���
        for(int i=0;i<manager.countRecipes();i++){
            Recipe rcp = manager.getRecipe(i);
            System.out.println(rcp.getTitle());
        }
    }
}
