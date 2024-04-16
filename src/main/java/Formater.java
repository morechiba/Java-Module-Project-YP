public class Formater {
    float sumForPerson = 0;
    String formatItog(float sumForPerson) {
        this.sumForPerson = sumForPerson;
        int formaterBase = (int)sumForPerson;
        String rubl = "";

        if(formaterBase >= 100) {
            formaterBase = formaterBase % 100;
        }
        if(formaterBase > 20){
            formaterBase = formaterBase % 10;
        }

        if (formaterBase == 1) {
            rubl = "рубль";
        } else if (formaterBase > 1 && formaterBase < 5){
            rubl = "рубля";
        } else {
            rubl = "рублей";
        }
        String itog = String.format("%.2f %s", sumForPerson, rubl);
        return itog;
    }

}
