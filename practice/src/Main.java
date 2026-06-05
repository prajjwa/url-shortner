import static java.lang.Thread.sleep;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() throws ExecutionException, InterruptedException {
  //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
  // to see how IntelliJ IDEA suggests fixing it.

    CompletableFuture<String> fetchUsers=CompletableFuture.supplyAsync(()->{

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return fetchUsers();

    });


    CompletableFuture<String> connectToDB=CompletableFuture.supplyAsync(()->{
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return connectToDB();


    });

    CompletableFuture<String> queryExecution=CompletableFuture.supplyAsync(()->{
        try{
            Thread.sleep(500);
        }
        catch (InterruptedException e)
        {
            throw  new RuntimeException(e);
        }

        return executeQuery();
    });

    CompletableFuture<Void> all=CompletableFuture.allOf(fetchUsers,
            connectToDB,queryExecution);

    all.get();


    System.out.println(fetchUsers.get());
    System.out.println(connectToDB.get());
    System.out.println(queryExecution.get());

}


private  String fetchUsers()
{
    return "Users fetched";
}

private String connectToDB()
{
    return "DB Connected";
}

private String executeQuery()
{
    return "Query executed";
}


