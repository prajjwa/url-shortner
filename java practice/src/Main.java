//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    PriorityQueue<Students> queue=new PriorityQueue<>(
            Comparator.comparing((Students s)->s.getPriorityLevel()).reversed()
    );

    queue.add(new Students("Prajjwal","Mark",23));
    queue.add(new Students("Mark","Time",222));

    while(!queue.isEmpty())
    {
        Students students=queue.poll();
        System.out.println(students.toString());
    }

}
