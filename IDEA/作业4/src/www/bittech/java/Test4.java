package www.bittech.java;

//猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不过瘾，又多吃了一个
//第二天早上又将剩下的桃子吃掉一半，又多吃了一个。以后每天早上都吃了前一天剩下的一半零一个。
//到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。
//递推公式：前一天的桃子数=(后一天桃子数+1)*2
public class Test4 {
    public static void main(String[] args) {
        System.out.println("桃子的总数是："+peach(1));
    }
    public static int peach(int n) {
        if (n == 10) {
            return 1;
        }
        return (peach(n+1)+1)*2;
    }
}
