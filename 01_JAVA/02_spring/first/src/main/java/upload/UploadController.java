package upload;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	// uploadform 보여주는 메서드
	@GetMapping("/fileupload")
	public String uploadform() {
		return "upload/uploadform";
	}

	// 파일선택 받아서 업로드 처리해주는 메서드
	@PostMapping("/fileupload")
	public String uploadprocess(@ModelAttribute("dto") UploadDTO dto) throws IOException {
		// c:/ upload 폴더에 업로드했던 이름 그대로 저장
		// 저장한 결과 객체를 뷰로 전달
		// uploadprocess.jsp
		String savePath = "c:/upload/";
		MultipartFile mf1 = dto.getFile1();
		// 파일명 추출
		mf1.getOriginalFilename();
		String filename1 = mf1.getOriginalFilename();
		// 파일이름.확장자 분리
		String beforeext1 = filename1.substring(0, filename1.lastIndexOf('.'));
		String ext1 = filename1.substring(filename1.lastIndexOf('.'));
		String newfilename1 = beforeext1 + "(" + UUID.randomUUID().toString() + ")" + ext1;

		// 파일내용 추출해서 c:/upload/filename1 저장
		File serverfile1 = new File(savePath + filename1);
		mf1.transferTo(serverfile1);

		MultipartFile mf2 = dto.getFile2();
		// 파일명2 추출
		mf2.getOriginalFilename();
		String filename2 = mf2.getOriginalFilename();
		// 파일이름.확장자 분리
		String beforeext2 = filename2.substring(0, filename2.lastIndexOf('.'));
		String ext2 = filename1.substring(filename2.lastIndexOf('.'));
		String newfilename2 = beforeext2 + "(" + UUID.randomUUID().toString() + ")" + ext2;
		// 파일내용2 추출해서 c:/upload/filename1 저장
		File serverfile2 = new File(savePath + filename2);
		mf2.transferTo(serverfile2);

		return "upload/uploadprocess";
	}

}
