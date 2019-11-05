package cc.cc.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Class PatternTest
 * @Description
 * @Author 张超超
 * @Date 2019/6/26 9:50
 */
public class PatternTest {
    public static void main(String[] args) {
        PatternTest pt = new PatternTest();
        pt.test1();
    }

    private void test1() {
        String regex = "\"user_id\":\"\\d+";
//        String regex = "\\d+";
//        String regex = "\"user_id\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(PatternTest.text);
        while (matcher.find()) {
            System.out.print(matcher.group().substring(11) + ",");
        }
    }



    private static String text = "2019-06-25 17:19:02.794  INFO 12725 --- [SimpleAsyncTaskExecutor-1] c.c.c.rabbitmq.receiver.ArticleReceiver  : UP-{\"article_id\":\"15613678233727\",\"user_id\":\"1904101928164783\",\"author_id\":\"1904021446041944\",\"create_time\":1561454342,\"valid\":0}\n" +
            "2019-06-25 17:19:02.804  INFO 12725 --- [SimpleAsyncTaskExecutor-1] c.c.c.rabbitmq.receiver.ArticleReceiver  : UP-{\"article_id\":\"15613678233727\",\"user_id\":\"1904101935032202\",\"author_id\":\"1904021446041944\",\"create_time\":1561454342,\"valid\":0}\n" +
            "2019-06-25 17:19:02.855  INFO 12725 --- [SimpleAsyncTaskExecutor-1] c.c.c.rabbitmq.receiver.ArticleReceiver  : UP-{\"article_id\":\"15613678233727\",\"user_id\":\"1904101938338772\",\"author_id\":\"1904021446041944\",\"create_time\":1561454342,\"valid\":0}\n" +
            "2019-06-25 17:19:03.000  INFO 12725 --- [SimpleAsyncTaskExecutor-1] c.c.c.rabbitmq.receiver.ArticleReceiver  : UP-{\"article_id\":\"15613678233727\",\"user_id\":\"1904110937468769\",\"author_id\":\"1904021446041944\",\"create_time\":1561454342,\"valid\":0}\n" +
            "2019-06-25 17:19:03.011  INFO 12725 --- [SimpleAsyncTaskExecutor-1] c.c.c.rabbitmq.receiver.ArticleReceiver  : UP-{\"article_id\":\"15613678233727\",\"user_id\":\"1904110945364239\",\"author_id\":\"1904021446041944\",\"create_time\":1561454343,\"valid\":0}\n" +
            "2019-06-25 17:19:03.015  INFO 12725 --- [SimpleAsyncTaskExecutor-1] c.c.c.rabbitmq.receiver.ArticleReceiver  : UP-{\"article_id\":\"15613678233727\",\"user_id\":\"1904110941288871\",\"author_id\":\"1904021446041944\",\"create_time\":1561454343,\"valid\":0}\n" +
            "2019-06-25 17:19:03.223  INFO 12725 --- [SimpleAsyncTaskExecutor-1] c.c.c.rabbitmq.receiver.ArticleReceiver  : UP-{\"article_id\":\"15613678233727\",\"user_id\":\"1904171113136340\",\"author_id\":\"1904021446041944\",\"create_time\":1561454343,\"valid\":0}\n" +
            "2019-06-25 17:19:03.279  INFO 12725 --- [SimpleAsyncTaskExecutor-1] c.c.c.rabbitmq.receiver.ArticleReceiver  : UP-{\"article_id\":\"15613678233727\",\"user_id\":\"1904171511543557\",\"author_id\":\"1904021446041944\",\"create_time\":1561454343,\"valid\":0}\n" +
            "2019-06-25 17:19:03.307  INFO 12725 --- [SimpleAsyncTaskExecutor-1] c.c.c.rabbitmq.receiver.ArticleReceiver  : UP-{\"article_id\":\"15613678233727\",\"user_id\":\"1904241351243668\",\"author_id\":\"1904021446041944\",\"create_time\":1561454343,\"valid\":0}\n" +
            "2019-06-25 17:19:03.408  INFO 12725 --- [SimpleAsyncTaskExecutor-1] c.c.c.rabbitmq.receiver.ArticleReceiver  : UP-{\"article_id\":\"15613678233727\",\"user_id\":\"1904021453088292\",\"author_id\":\"1904021446041944\",\"create_time\":1561454343,\"valid\":0}\n" +
            "2019-06-25 17:19:03.547  INFO 12725 --- [SimpleAsyncTaskExecutor-1] c.c.c.rabbitmq.receiver.ArticleReceiver  : UP-{\"article_id\":\"15613678233727\",\"user_id\":\"1904101851566420\",\"author_id\":\"1904021446041944\",\"create_time\":1561454343,\"valid\":0}\n" +
            "2019-06-25 17:19:03.553  INFO 12725 --- [SimpleAsyncTaskExecutor-1] c.c.c.rabbitmq.receiver.ArticleReceiver  : UP-{\"article_id\":\"15613678233727\",\"user_id\":\"1904101907386558\",\"author_id\":\"1904021446041944\",\"create_time\":1561454343,\"valid\":0}\n" +
            "2019-06-25 17:19:03.556  INFO 12725 --- [SimpleAsyncTaskExecutor-1] c.c.c.rabbitmq.receiver.ArticleReceiver  : UP-{\"article_id\":\"15613678233727\",\"user_id\":\"1904241945316290\",\"author_id\":\"1904021446041944\",\"create_time\":1561454343,\"valid\":0}\n" +
            "2019-06-25 17:19:03.688  INFO 12725 --- [SimpleAsyncTaskExecutor-1] c.c.c.rabbitmq.receiver.ArticleReceiver  : UP-{\"article_id\":\"15613678233727\",\"user_id\":\"1904242053268366\",\"author_id\":\"1904021446041944\",\"create_time\":1561454343,\"valid\":0}\n" +
            "2019-06-25 17:19:03.796  INFO 12725 --- [SimpleAsyncTaskExecutor-1] c.c.c.rabbitmq.receiver.ArticleReceiver  : UP-{\"article_id\":\"15613678233727\",\"user_id\":\"1904281426359309\",\"author_id\":\"1904021446041944\",\"create_time\":1561454343,\"valid\":0}\n" +
            "2019-06-25 17:19:03.881  INFO 12725 --- [SimpleAsyncTaskExecutor-1] c.c.c.rabbitmq.receiver.ArticleReceiver  : UP-{\"article_id\":\"15613678233727\",\"user_id\":\"1905061036508799\",\"author_id\":\"1904021446041944\",\"create_time\":1561454343,\"valid\":0}\n" +
            "2019-06-25 17:19:03.883  INFO 12725 --- [SimpleAsyncTaskExecutor-1] c.c.c.rabbitmq.receiver.ArticleReceiver  : UP-{\"article_id\":\"15613678233727\",\"user_id\":\"1904281632279017\",\"author_id\":\"1904021446041944\",\"create_time\":1561454343,\"valid\":0}\n" +
            "2019-06-25 17:19:03.953  INFO 12725 --- [SimpleAsyncTaskExecutor-1] c.c.c.rabbitmq.receiver.ArticleReceiver  : UP-{\"article_id\":\"15613678233727\",\"user_id\":\"1905061052314355\",\"author_id\":\"1904021446041944\",\"create_time\":1561454343,\"valid\":0}\n" +
            "2019-06-25 17:19:04.035  INFO 12725 --- [SimpleAsyncTaskExecutor-1] c.c.c.rabbitmq.receiver.ArticleReceiver  : UP-{\"article_id\":\"15613678233727\",\"user_id\":\"1905081649361091\",\"author_id\":\"1904021446041944\",\"create_time\":1561454344,\"valid\":0}\n" +
            "2019-06-25 17:19:04.091  INFO 12725 --- [SimpleAsyncTaskExecutor-1] c.c.c.rabbitmq.receiver.ArticleReceiver  : UP-{\"article_id\":\"15613678233727\",\"user_id\":\"1905081713285669\",\"author_id\":\"1904021446041944\",\"create_time\":1561454344,\"valid\":0}\n" +
            "2019-06-25 17:19:04.105  INFO 12725 --- [SimpleAsyncTaskExecutor-1] c.c.c.rabbitmq.receiver.ArticleReceiver  : UP-{\"article_id\":\"15613678233727\",\"user_id\":\"1905091126525692\",\"author_id\":\"1904021446041944\",\"create_time\":1561454344,\"valid\":0}\n" +
            "2019-06-25 17:19:04.172  INFO 12725 --- [SimpleAsyncTaskExecutor-1] c.c.c.rabbitmq.receiver.ArticleReceiver  : UP-{\"article_id\":\"15613678233727\",\"user_id\":\"1905091353285123\",\"author_id\":\"1904021446041944\",\"create_time\":1561454344,\"valid\":0}\n" +
            "2019-06-25 17:19:04.256  INFO 12725 --- [SimpleAsyncTaskExecutor-1] c.c.c.rabbitmq.receiver.ArticleReceiver  : UP-{\"article_id\":\"15613678233727\",\"user_id\":\"1905101603385618\",\"author_id\":\"1904021446041944\",\"create_time\":1561454344,\"valid\":0}\n" +
            "2019-06-25 17:19:04.307  INFO 12725 --- [SimpleAsyncTaskExecutor-1] c.c.c.rabbitmq.receiver.ArticleReceiver  : UP-{\"article_id\":\"15613678233727\",\"user_id\":\"1905101737324335\",\"author_id\":\"1904021446041944\",\"create_time\":1561454344,\"valid\":0}\n" +
            "2019-06-25 17:19:04.321  INFO 12725 --- [SimpleAsyncTaskExecutor-1] c.c.c.rabbitmq.receiver.ArticleReceiver  : UP-{\"article_id\":\"15613678233727\",\"user_id\":\"1905151415103568\",\"author_id\":\"1904021446041944\",\"create_time\":1561454344,\"valid\":0}\n" +
            "2019-06-25 17:19:04.398  INFO 12725 --- [SimpleAsyncTaskExecutor-1] c.c.c.rabbitmq.receiver.ArticleReceiver  : UP-{\"article_id\":\"15613678233727\",\"user_id\":\"1905151429362068\",\"author_id\":\"1904021446041944\",\"create_time\":1561454344,\"valid\":0}\n" +
            "2019-06-25 17:19:04.466  INFO 12725 --- [SimpleAsyncTaskExecutor-1] c.c.c.rabbitmq.receiver.ArticleReceiver  : UP-{\"article_id\":\"15613678233727\",\"user_id\":\"1905151538496607\",\"author_id\":\"1904021446041944\",\"create_time\":1561454344,\"valid\":0}\n" +
            "2019-06-25 17:19:04.520  INFO 12725 --- [SimpleAsyncTaskExecutor-1] c.c.c.rabbitmq.receiver.ArticleReceiver  : UP-{\"article_id\":\"15613678233727\",\"user_id\":\"1904202254264274\",\"author_id\":\"1904021446041944\",\"create_time\":1561454344,\"valid\":0}\n" +
            "2019-06-25 17:42:59.498  INFO 12725 --- [SimpleAsyncTaskExecutor-1] c.c.c.rabbitmq.receiver.ArticleReceiver  : UP-{\"article_id\":\"15613678233727\",\"user_id\":\"1906251735245085\",\"author_id\":\"1904021446041944\",\"create_time\":1561455779,\"valid\":0}";
}
