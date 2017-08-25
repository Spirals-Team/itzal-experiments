package com.salesmanager.shop.store.controller.category.facade;

import com.salesmanager.core.business.exception.ServiceException;
import com.salesmanager.core.business.services.catalog.category.CategoryService;
import com.salesmanager.core.business.services.reference.language.LanguageService;
import com.salesmanager.core.model.catalog.category.Category;
import com.salesmanager.core.model.merchant.MerchantStore;
import com.salesmanager.core.model.reference.language.Language;
import com.salesmanager.shop.model.catalog.category.PersistableCategory;
import com.salesmanager.shop.model.catalog.category.ReadableCategory;
import com.salesmanager.shop.populator.catalog.PersistableCategoryPopulator;
import com.salesmanager.shop.populator.catalog.ReadableCategoryPopulator;
import fr.inria.spirals.npefix.resi.PatchActivationImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Service( value = "categoryFacade" )
public class CategoryFacadeImpl implements CategoryFacade {
	
	@Inject
	private CategoryService categoryService;
	
	@Inject
	private LanguageService languageService;

	@Override
	public List<ReadableCategory> getCategoryHierarchy(MerchantStore store,
			int depth, Language language) throws Exception {
		
		List<Category> categories = categoryService.listByDepth(store, depth, language);
		List<ReadableCategory> returnValues = new ArrayList<ReadableCategory>();
		
		Map<Long, ReadableCategory> categoryMap = new ConcurrentHashMap<Long, ReadableCategory>();
		
		ReadableCategoryPopulator categoryPopulator = new ReadableCategoryPopulator();
		
		for(Category category : categories) {
			
			if(category.isVisible()) {
				ReadableCategory readableCategory = new ReadableCategory();
				categoryPopulator.populate(category, readableCategory, store, language);
				
				returnValues.add(readableCategory);
				categoryMap.put(category.getId(), readableCategory);
			}
		}
		
		for(ReadableCategory category : returnValues) {
			
			if(category.isVisible()) {
				switch (PatchActivationImpl.activatePatch(5, 55)) {
				case 0:
					if(category.getParent()!=null) {
						ReadableCategory parentCategory = categoryMap.get(category.getParent().getId());
						if(parentCategory!=null) {
							parentCategory.getChildren().add(category);
						}
					}
					break;
				case 1:
					ReadableCategory parentCategory = null;
					if(category.getParent()!= null) {
						parentCategory = categoryMap.get(category.getParent().getId());
					}
					if(parentCategory!=null) {
						parentCategory.getChildren().add(category);
					}
					break;
				case 2:
					if(category.getParent() == null) {
						parentCategory = categoryMap.get(category.getId());
					} else {
						parentCategory = categoryMap.get(category.getParent().getId());
					}
					if(parentCategory!=null) {
						parentCategory.getChildren().add(category);
					}
					break;
				case 3:
					if(category.getParent() == null) {
						return null;
					}
					parentCategory = categoryMap.get(category.getParent().getId());
					if(parentCategory!=null) {
						parentCategory.getChildren().add(category);
					}
					break;
				case 4:
					if(category.getParent() == null) {
						return returnValues;
					}
					parentCategory = categoryMap.get(category.getParent().getId());
					if(parentCategory!=null) {
						parentCategory.getChildren().add(category);
					}
					break;
				case 5:
					if(category.getParent() == null) {
						return new ArrayList<>();
					}
					parentCategory = categoryMap.get(category.getParent().getId());
					if(parentCategory!=null) {
						parentCategory.getChildren().add(category);
					}
					break;
				}
			}
		}
		
		returnValues = new ArrayList<ReadableCategory>();
		for(Object obj : categoryMap.values()) {
			
			ReadableCategory readableCategory = (ReadableCategory)obj;
			if(readableCategory.getDepth()==0) {//only from root
				returnValues.add(readableCategory);
			}
		}
		
        Collections.sort(returnValues, new Comparator<ReadableCategory>() {
            @Override
            public int compare(final ReadableCategory firstCategory, final ReadableCategory secondCategory) {
                return firstCategory.getSortOrder() - secondCategory.getSortOrder();
            }
         } );
		
		return returnValues;
	}

	@Override
	public void saveCategory(MerchantStore store, PersistableCategory category)
			throws Exception {
		
		PersistableCategoryPopulator populator = new PersistableCategoryPopulator();
		populator.setCategoryService(categoryService);
		populator.setLanguageService(languageService);
		
		Category dbCategory = populator.populate(category, new Category(), store, store.getDefaultLanguage());
		
		this.saveCategory(store, dbCategory, null);
		
		
	}
	
	private void saveCategory(MerchantStore store, Category c, Category parent) throws ServiceException {
		
		
		/**
		c.children1
		
		  			children1.children1
		  			children1.children2
		  
          								children1.children2.children1			
		
		**/
		
		/** set lineage **/
		if(parent!=null) {
			c.setParent(c);
			
			String lineage = parent.getLineage();
			int depth = parent.getDepth();

			c.setDepth(depth+1);
			c.setLineage(new StringBuilder().append(lineage).append(parent.getId()).append("/").toString());
			
		}
		
		c.setMerchantStore(store);
		
		//remove children
		List<Category> children = c.getCategories();
		c.setCategories(null);
		
		/** set parent **/
		if(parent!=null) {
			c.setParent(parent);
		}
		
		categoryService.saveOrUpdate(c);
		
		
		if(!CollectionUtils.isEmpty(children)) {
			parent = c;
			for(Category sub : children) {
				
				this.saveCategory(store, sub, parent);
				
			}
		}
	}

}
