package com.home.samik.SpringBootWithAngular.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.home.samik.SpringBootWithAngular.dao.FileDao;
import com.home.samik.SpringBootWithAngular.dto.StockDto;
import com.home.samik.SpringBootWithAngular.entity.StockDetails;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileDao fileDao;

	@Autowired
	ServletContext context;

	@Override
	public void uploadFileDataToDB(MultipartFile file) throws Exception {
		if (null != file) {
			File convFile = multipartToFile(file);
			List<List<String>> list = getTheExcelDataToList(convFile);
			List<StockDetails> listOfStocks = getListOfStocks(list);
			fileDao.uploadFileDataToDB(listOfStocks);
		}
	}

	private List<StockDetails> getListOfStocks(List<List<String>> list) {
		List<StockDetails> listOfStocks = new ArrayList<>();

		list.parallelStream().forEach(innerList -> {
			StockDetails stockDetails = new StockDetails();
			stockDetails.setDate(innerList.get(0));
			stockDetails.setCompanySymbol(innerList.get(1));
			stockDetails.setOpen(Float.parseFloat(innerList.get(2)));
			stockDetails.setClose(Float.parseFloat(innerList.get(3)));
			stockDetails.setLow(Float.parseFloat(innerList.get(4)));
			stockDetails.setHigh(Float.parseFloat(innerList.get(5)));
			stockDetails.setVolume(Long.parseLong(innerList.get(6)));
			listOfStocks.add(stockDetails);
		});
		return listOfStocks;
	}

	private List<List<String>> getTheExcelDataToList(File file) throws Exception {
		List<List<String>> list = new ArrayList<>();

		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheetAt(0);
		DataFormatter dataFormatter = new DataFormatter();

		Iterator<Row> rowIterator = sheet.rowIterator();
		Row headerRow = rowIterator.next();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();

			List<String> listInner = new ArrayList<>();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				String cellValue = dataFormatter.formatCellValue(cell);
				listInner.add(cellValue);
			}
			list.add(listInner);
		}
		return list;
	}

	private File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
		String originalFilename = multipart.getOriginalFilename();
		File convFile = new File(context.getRealPath("") + File.separator + originalFilename);
		multipart.transferTo(convFile);
		return convFile;
	}

	@Override
	public List<StockDetails> getAllStockData(Integer pageIndex, Integer changeNoOfRecords, String orderByCol) throws Exception {
		return fileDao.getAllStockData(pageIndex, changeNoOfRecords, orderByCol);
	}

	@Override
	public List<StockDetails> getDetailsByName(String stockName) throws Exception {
		return fileDao.getDetailsByName(stockName);
	}

	@Override
	public List<StockDetails> getDetailsByPerformance() {
		return fileDao.getDetailsByPerformance();
	}

	@Override
	public Integer getTotalNoOfStock() {
		return fileDao.getTotalNoOfStock();
	}

	@Override
	public Integer deleteStockById(Integer id) throws Exception {
		return fileDao.deleteStockById(id);
	}

	@Override
	public Integer duplicateStock(StockDto stockDto) throws Exception {
		return fileDao.duplicateStock(stockDto);
	}

	@Override
	public Integer saveStock(StockDto stockDto) throws Exception {
		return fileDao.saveStock(stockDto);
	}

	@Override
	public Integer editStock(Integer id, StockDto stockDto) throws Exception {
		return fileDao.editStock(id, stockDto);
	}

}
