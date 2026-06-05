//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() throws InterruptedException, ExecutionException {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.


    XClass xClass=new XClass();

    int output=xClass.getNumber(10);

   ExecutorService executors=Executors.newFixedThreadPool(2);

   Future<Integer> val=executors.submit(new YClass(output));

   Future<Integer> valueZ=executors.submit(new Zclass(output));

    System.out.println(val.get());
    System.out.println(valueZ.get());


    executors.close();

    // 3 functions
    // x y z
    // all take input integer
    // y and z depends on output from x
    // y and z are independet



}
