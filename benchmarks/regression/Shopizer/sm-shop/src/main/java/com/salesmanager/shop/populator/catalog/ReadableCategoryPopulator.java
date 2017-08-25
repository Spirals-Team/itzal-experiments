package com.salesmanager.shop.populator.catalog;

import com.salesmanager.core.business.exception.ConversionException;
import com.salesmanager.core.business.utils.AbstractDataPopulator;
import com.salesmanager.core.model.catalog.category.Category;
import com.salesmanager.core.model.catalog.category.CategoryDescription;
import com.salesmanager.core.model.merchant.MerchantStore;
import com.salesmanager.core.model.reference.language.Language;
import com.salesmanager.shop.model.catalog.category.ReadableCategory;
import fr.inria.spirals.npefix.resi.PatchActivationImpl;

public class ReadableCategoryPopulator extends
		AbstractDataPopulator<Category, ReadableCategory> {

	@Override
	public ReadableCategory populate(Category source, ReadableCategory target,
			MerchantStore store, Language language) throws ConversionException {
		
		
		target.setLineage(source.getLineage());
		if(source.getDescriptions()!=null && source.getDescriptions().size()>0) {
			
			CategoryDescription description = source.getDescription();
			if(source.getDescriptions().size()>1) {
				for(CategoryDescription desc : source.getDescriptions()) {
					if(desc.getLanguage().getCode().equals(language.getCode())) {
						description = desc;
						break;
					}
				}
			}
		
		
		
			if(description!=null) {
				com.salesmanager.shop.model.catalog.category.CategoryDescription desc = new com.salesmanager.shop.model.catalog.category.CategoryDescription();
				desc.setFriendlyUrl(description.getSeUrl());
				desc.setName(description.getName());
				desc.setDescription(description.getName());
				desc.setKeyWords(description.getMetatagKeywords());
				desc.setHighlights(description.getCategoryHighlight());
				desc.setTitle(description.getMetatagTitle());
				desc.setMetaDescription(description.getMetatagDescription());
				
				target.setDescription(desc);
			}
		
		}
		switch (PatchActivationImpl.activatePatch(5, 51)) {
		case 0:
			if(source.getParent()!=null) {
				com.salesmanager.shop.model.catalog.category.Category parent = new com.salesmanager.shop.model.catalog.category.Category();
				parent.setCode(source.getParent().getCode());
				parent.setId(source.getParent().getId());
				target.setParent(parent);
			}
			break;
		case 1:
			com.salesmanager.shop.model.catalog.category.Category parent = new com.salesmanager.shop.model.catalog.category.Category();
			if(source.getParent()!=null) {
				parent.setCode(source.getParent().getCode());
				parent.setId(source.getParent().getId());
			}
			target.setParent(parent);
			break;
		case 2:
			if(source.getParent()==null) {
				return target;
			} else {
				parent = new com.salesmanager.shop.model.catalog.category.Category();
				parent.setCode(source.getParent().getCode());
				parent.setId(source.getParent().getId());
				target.setParent(parent);
			}
			break;
		case 3:
			if(source.getParent() == null) {
				return null;
			} else {
				parent = new com.salesmanager.shop.model.catalog.category.Category();
				parent.setCode(source.getParent().getCode());
				parent.setId(source.getParent().getId());
				target.setParent(parent);
			}
			break;
		case 4:
			parent = new com.salesmanager.shop.model.catalog.category.Category();
			if(source.getParent()!=null) {
				parent.setCode(source.getCode());
				parent.setId(source.getId());
			}
			target.setParent(parent);
			break;
		case 5:
			parent = new com.salesmanager.shop.model.catalog.category.Category();
			if(source.getParent()!=null) {
				parent.setCode(parent.getCode());
				parent.setId(parent.getId());
			}
			target.setParent(parent);
			break;
		}

		
		target.setCode(source.getCode());
		target.setId(source.getId());
		target.setDepth(source.getDepth());
		target.setSortOrder(source.getSortOrder());
		target.setVisible(source.isVisible());

		return target;
		
	}

	@Override
	protected ReadableCategory createTarget() {
		return null;
	}

}
