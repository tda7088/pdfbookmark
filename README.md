# pdfbookmark
从一个pdf文件复制书签到另一个pdf文件

使用方法：
修改bin/run.bat中的pdf文件参数,不包含扩展名“.pdf”

如f盘pdf目录包含“测试.pdf”和“测试_orc.pdf”两个文件，“测试.pdf”文件带书签，“测试_orc.pdf”文件不带书签，执行以下命令，会将“测试.pdf”的书签复制到“测试_orc.pdf”文件内：
java -cp itextpdf-5.5.12.jar;copybookmark.jar com.ztf.pdfbookmark.CopyBookMark "f:/pdf/测试"

执行命令后，会先导出xml格式的书签文件，与“测试_orc.pdf”文件合并，再生成带书签的“测试_ocr2.pdf”文件。
