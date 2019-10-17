package cn.dou.Dblog.service;

import cn.dou.Dblog.dao.ArticleTagDao;
import cn.dou.Dblog.dao.TagDao;
import cn.dou.Dblog.model.ArticleTag;
import cn.dou.Dblog.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TagService {
    @Autowired
    private TagDao tagDao;

    @Autowired
    private ArticleTagDao articleTagDao;

    public Tag selectByName(String name){
        return tagDao.selectByName(name);
    }

    public List<Tag> getAllTag(){
        return tagDao.selectAll();
    }

    public List<Tag> getTagByArticleId(int articleId){
        return articleTagDao.selectByArticleId(articleId);
    }

    public int addTag(Tag tag){
        return tagDao.insertTag(tag)>0?tag.getId():0;
    }

    public int addArticleTag(ArticleTag articleTag){
        return articleTagDao.insertArticleTag(articleTag);
    }

    public void updateCount(int tagId,int count){
        tagDao.updateCount(tagId,count);
    }
}
