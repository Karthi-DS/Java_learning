class Variables{
    int instanceVar = 10;
    static String name = "karthi";

    public void showVariables(){
        System.out.println("Instance Var: "+ instanceVar);
        System.out.println("static var: "+ name);
    }
}

class VariablesDemo{
    static Variables var1 = new Variables();
    static Variables var2 = new Variables();
    public static void main(String[] args){
        var1.instanceVar = 20;
        Variables.name = "rahul";
        var1.showVariables();
        var2.showVariables();
    }
}