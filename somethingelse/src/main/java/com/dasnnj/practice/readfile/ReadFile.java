package com.dasnnj.practice.readfile;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Description <P> DO :  <P>
 *
 * @author DASNNJ  <a href="mailto:dasnnj@outlook.com"> dasnnj@outlook.com </a>
 * @date 2019-06-05 14:29
 */
public class ReadFile {
    private List<String> list;
    /**
     * Read log file.
     *
     * @param fileAddress the file address
     */
    List<String> readLogFile(String fileAddress) {
        list = new ArrayList<>();
        File file = new File(fileAddress);
        if (!file.exists()) {
            throw new RuntimeException("file not exist");
        }
        try {
            LineIterator iterator = FileUtils.lineIterator(file, "UTf-8");
            while (iterator.hasNext()) {
                list.add(iterator.nextLine());
                // TODO
                // System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Apache commons io.
     *
     * @param filePath the file path
     *
     * @Description: 使用 Apache Commons IO 流逐行读取文件 Maven 依赖: <!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
     * <dependency> <groupId>commons-io</groupId> <artifactId>commons-io</artifactId> <version>2.6</version> </dependency>
     */
    public void apacheCommonsIo(String filePath) {
        list = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        }

        try {
            LineIterator iterator = FileUtils.lineIterator(file, "UTf-8");
            while (iterator.hasNext()) {
                String line = iterator.nextLine();
                list.add(line);
                // TODO
                // System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        }
    }

    /**
     * Scanner.
     *
     * @param filePath the file path
     *
     * @Description: 使用 Scanner 类逐行读取
     */
    public void scanner(String filePath) {
        list = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        }

        FileInputStream fileInputStream = null;
        Scanner scanner = null;
        try {
            fileInputStream = new FileInputStream(file);
            scanner = new Scanner(fileInputStream, "UTF-8");

            while (scanner.hasNextLine()) {
                // TODO things
                String line = scanner.nextLine();
                list.add(line);
                // System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (scanner != null) {
                scanner.close();
            }
        }
    }

    /**
     * Files.
     *
     * @param filePath the file path
     *
     * @Description: 使用 Files 一次性读取所有行 Maven 依赖: <!-- https://mvnrepository.com/artifact/com.google.guava/guava --> <dependency>
     * <groupId>com.google.guava</groupId> <artifactId>guava</artifactId> <version>r05</version>
     * </dependency>
     */
    public void files(String filePath) {
        list = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        }

        try {
            List<String> fileLines = Files.readLines(file, Charsets.UTF_8);
            for (String str : fileLines) {
                list.add(str);
                // TODO things
                // System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * File utils.
     *
     * @param filePath the file path
     *
     * @Description: 使用 FileUtils 一次性将文件所有行读入内存 Maven 依赖: <!-- https://mvnrepository.com/artifact/commons-io/commons-io --> <dependency>
     * <groupId>commons-io</groupId> <artifactId>commons-io</artifactId> <version>2.6</version>
     * </dependency>
     */
    public void fileUtils(String filePath) {
        list = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        }

        try {
            List<String> fileLines = FileUtils.readLines(file, "UTF-8");
            for (String str : fileLines) {
                list.add(str);
                // TODO
                // System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Buffered input stream.
     *
     * @param filePath the file path
     */
    public void bufferedInputStream(String filePath) {
        list = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        }

        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            bufferedInputStream = new BufferedInputStream(fileInputStream);

            int temp;
            char character;
            String line = "";
            while ((temp = bufferedInputStream.read()) != -1) {
                character = (char) temp;
                if (character != '\n') {
                    line += character;
                } else {
                    // TODO
                    // System.out.println(line);
                    list.add(line);
                    line = "";
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * File input stream.
     *
     * @param filePath the file path
     *
     * @Description: 使用 FileInputStream 逐字符读取文件
     */
    public void fileInputStream(String filePath) {
        list = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        }

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            int temp;
            char character;
            String line = "";
            while ((temp = fileInputStream.read()) != -1) {
                character = (char) temp;
                if (character != '\n') {
                    line += character;
                } else {
                    // TODO
                    list.add(line);
                    // System.out.println(line);
                    line = "";
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Input stream reader.
     *
     * @param filePath the file path
     *
     * @Description: 使用 InputStreamReader 逐行读取文件
     */
    public void inputStreamReader(String filePath) {
        list = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        }

        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        try {
            fileInputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(fileInputStream);
            int temp;
            char character;
            String line = "";
            while ((temp = inputStreamReader.read()) != -1) {
                character = (char) temp;
                if (character != '\n') {
                    line += character;
                } else {
                    list.add(line);
                    // TODO
                    // System.out.println(line);
                    line = "";
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Buffered reader.
     *
     * @param filePath the file path
     *
     * @Description: 使用 BufferedReader 逐行读取文件内容
     */
    public void bufferedReader(String filePath) {
        list = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        }

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                // TODO things
                list.add(line);
                // System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
