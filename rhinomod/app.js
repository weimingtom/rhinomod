//print('hello, world!');
//sleep(1000);
//toast('hello, toast!');

function fib(n){
    if(n==1||n==2){
    	print(">>>END<<<");
        return 1;
    }
    return fib(n-1)+fib(n-2);
}
print(fib(10));
