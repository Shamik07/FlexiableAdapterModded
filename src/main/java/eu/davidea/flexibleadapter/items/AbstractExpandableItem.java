/*
 * Copyright 2016 Davide Steduto
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.davidea.flexibleadapter.items;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic implementation of {@link IExpandable} interface with most useful methods to manage
 * expansion and sub items.<br/>
 * This abstract class extends also {@link AbstractFlexibleItem}.
 *
 * @author Davide Steduto
 * @since 17/01/2016 Created
 */
public abstract class AbstractExpandableItem<VH extends RecyclerView.ViewHolder, S extends IFlexible>
		extends AbstractFlexibleItem<VH>
		implements IExpandable<VH, S> {

	/* Flags for FlexibleAdapter */
	private boolean mExpanded = false;

	/* subItems list */
	private List<S> mSubItems;

	/*--------------------*/
	/* EXPANDABLE METHODS */
	/*--------------------*/

	@Override
	public boolean isExpanded() {
		return mExpanded;
	}

	@Override
	public void setExpanded(boolean expanded) {
		this.mExpanded = expanded;
	}

	/*-------------------*/
	/* SUB ITEMS METHODS */
	/*-------------------*/

	@Override
	public final List<S> getSubItems() {
		return mSubItems;
	}

	public final boolean hasSubItems() {
		return mSubItems!= null && mSubItems.size() > 0;
	}

	public IFlexible setSubItems(List<S> subItem) {
		mSubItems = new ArrayList<>(subItem);
		return this;
	}

	public final int getSubItemsCount() {
		return mSubItems != null ? mSubItems.size() : 0;
	}

	public S getSubItem(int position) {
		if (mSubItems != null && position >= 0 && position < mSubItems.size()) {
			return mSubItems.get(position);
		}
		return null;
	}

	public final int getSubItemPosition(S subItem) {
		return mSubItems != null ? mSubItems.indexOf(subItem) : -1;
	}

	public void addSubItem(S subItem) {
		if (mSubItems == null)
			mSubItems = new ArrayList<S>();
		mSubItems.add(subItem);
	}

	public void addSubItem(int position, S subItem) {
		if (mSubItems != null && position >= 0 && position < mSubItems.size()) {
			mSubItems.add(position, subItem);
		} else
			addSubItem(subItem);
	}

	public boolean contains(S subItem) {
		return mSubItems != null && mSubItems.contains(subItem);
	}

	public boolean removeSubItem(S item) {
		return item != null && mSubItems.remove(item);
	}

	public boolean removeSubItem(int position) {
		if (mSubItems != null && position >= 0 && position < mSubItems.size()) {
			mSubItems.remove(position);
			return true;
		}
		return false;
	}

}