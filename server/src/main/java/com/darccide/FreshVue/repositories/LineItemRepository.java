
package com.darccide.FreshVue.repositories;

import com.darccide.FreshVue.entities.LineItem;
import com.darccide.FreshVue.entities.LineItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineItemRepository extends JpaRepository<LineItem, LineItemPK> {}
