//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.

    List<List<Integer>> listArr=List.of(
            List.of(2,1),
            List.of(2,21)
    );


    long num=listArr.stream()
            .flatMap(List::stream)
            .count();

    System.out.println(num);







}
