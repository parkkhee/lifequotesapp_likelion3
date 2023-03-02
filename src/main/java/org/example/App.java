package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App{
    static ArrayList<Book> books = new ArrayList<>();
    public void run(){
        System.out.println("== 명언 앱 ==");
        Scanner sc = new Scanner(System.in);
        Long lq_no=1L;


        while (true) {

            System.out.printf("명령) ");
            String line = sc.nextLine().trim();
            if (line.equals("종료")) {


                try {
                    File file = new File("C:/Users/kwan/Desktop/test/example.txt");
                    // 파일 출력 스트림 생성
                    FileOutputStream fos = new FileOutputStream(file);
                    // PrintWriter로 출력 스트림 감싸기
                    PrintWriter pw = new PrintWriter(fos);
                    // ArrayList의 모든 요소를 파일에 쓰기
                    for (Book book_list : books) {
                        pw.println(book_list.getNo()+"/"+book_list.getAuthor()+"/"+book_list.getContent());
                    }

                    // 출력 스트림 닫기
                    pw.close();
                    fos.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
            } else if (line.equals("등록")) {

                System.out.printf("명언 : ");
                String lifequotes = sc.nextLine().trim();
                System.out.printf("작가 : ");
                String author = sc.nextLine().trim();
                System.out.println(lq_no+"번 명언이 등록되었습니다.");

                books.add(new Book(lq_no, author, lifequotes));
                lq_no++;
            } else if (line.equals("목록")) {

                if(books.isEmpty()){
                    try {
                        File file = new File("C:/Users/kwan/Desktop/test/example.txt");
                        FileInputStream fis = new FileInputStream(file);
                        // BufferedReader로 입력 스트림 감싸기
                        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                        // 파일의 모든 라인을 읽어서 ArrayList에 저장
                        String str;
                        while ((str = br.readLine()) != null) {
                            String[] txt_in = str.split("/");
                            books.add(new Book(Long.parseLong(txt_in[0]), txt_in[1], txt_in[2]));
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


                System.out.println("------------------------------");
                for (int i = books.size()-1; i >= 0; i--) {
                    Book now_book = books.get(i);
                    System.out.println(now_book.getNo()+" / "+now_book.getAuthor()+" / "+now_book.getContent());

                }
            } else if (line.contains("삭제?id=")) {
                String tmp = "";
                tmp += line.charAt(line.length() - 1);
                Long lq_isE_no = Long.parseLong(tmp);

                if (isno(lq_isE_no)) {
                    books.remove((int)(lq_isE_no - 1));
                    System.out.println(lq_isE_no + "번 명언이 삭제되었습니다.");
                } else {
                    System.out.println(lq_isE_no+"번 명언은 존재하지 않습니다.");
                }

            } else if (line.contains("수정?id=")) {

                String tmp = "";
                tmp += line.charAt(line.length() - 1);
                Long edit_no = Long.parseLong(tmp);
                Book now_book = search_from_no(edit_no);

                System.out.printf("명언(기존) : ");
                System.out.printf(now_book.getContent() + "\n");
                System.out.printf("명언 : ");
                String edit_ctt = sc.nextLine();
                now_book.setContent(edit_ctt);

                System.out.println("작가(기존) : " + now_book.getAuthor());
                System.out.printf("작가 : ");
                String edit_aut = sc.nextLine();
                now_book.setAuthor(edit_aut);

            }

        }
    }

    public static boolean isno(Long lq_isE_no){
        for (int i = 0; i < books.size(); i++) {

            if (books.get(i).getNo() == lq_isE_no) {
                return true;
            }

        }
        return false;
    }

    public Book search_from_no(Long no) {
        for (int i = 0; i < books.size(); i++) {

            if (no == books.get(i).getNo()) {
                return books.get(i);
            }

        }
        return null;
    }

}
