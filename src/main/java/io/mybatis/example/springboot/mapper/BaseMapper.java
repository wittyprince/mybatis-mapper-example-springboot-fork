package io.mybatis.example.springboot.mapper;

import io.mybatis.example.springboot.BaseEntity;
import io.mybatis.mapper.Mapper;
import io.mybatis.mapper.example.Example;
import io.mybatis.mapper.fn.Fn;
import org.springframework.util.ObjectUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * base mapper
 *
 * @author WangChen
 * Created on 2023/5/4
 * @since 1.0
 */
public interface BaseMapper<T extends BaseEntity, I extends String> extends Mapper<T, I> {

    default T getByBid(String bid) {
        if (bid == null) {
            return null;
        }
//        Example<T> example = new Example<>();
//        Example.Criteria<T> criteria = example.createCriteria();
//        criteria.andEqualTo(T::getBid, bid);
//        return selectOneByExample(example).orElse(null);
        return selectByFieldList(T::getBid, Collections.singletonList(bid)).stream().findFirst().orElse(null);
    }

//    default <F> List<T> selectByFieldList(Fn<T, F> field, Collection<F> fieldValueList) {
//        Example<T> example = new Example<>();
//        example.createCriteria().andIn((Fn<T, Object>) field.in(entityClass()), fieldValueList);
//        return selectByExample(example);
//    }

    default List<T> getByBids(List<String> bids) {
        return ObjectUtils.isEmpty(bids)
                ? Collections.emptyList()
                : selectByFieldList(T::getBid, bids);
    }

    default int deleteByBid(String bid) {
        return bid == null ? 0 : deleteByFieldList(T::getBid, Collections.singletonList(bid));
    }

    default int deleteByBids(List<String> bids) {
        if (bids == null || bids.isEmpty()) {
            return 0;
        }
        Example<T> example = new Example<>();
        example.createCriteria().andIn(T::getBid, bids);
        return deleteByExample(example);
    }

    default boolean updateByBid(T entity) {
        if (entity == null) {
            return false;
        }
        return this.updateByBid(entity, entity.getBid());
    }

    default boolean updateByBid(T entity, String bid) {
        if (entity == null || bid == null) {
            return false;
        }
//		entity.setUpdateBy();
//        entity.setUpdateTime(LocalDateTime.now());
        Example<T> example = new Example<>();
        example.createCriteria().andEqualTo(T::getBid, bid);
        int i = updateByExample(entity, example);
        return i == 1;
    }

    default T save(T entity) {
        if (entity == null) {
            return null;
        }
        if (entity.getBid() == null) {
            entity.setBid(String.valueOf(12312312));
        }
//		entity.setCreateBy();
//        entity.setCreateTime(LocalDateTime.now());
//        entity.setUpdateTime(LocalDateTime.now());
//		entity.setDeleted(false);
        int i = insert(entity);
        return getByBid(entity.getBid());
    }
}
